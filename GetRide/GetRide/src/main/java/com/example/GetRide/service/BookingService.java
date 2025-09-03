package com.example.GetRide.service;

import com.example.GetRide.dto.request.BookingRequest;
import com.example.GetRide.dto.response.BookingResponse;
import com.example.GetRide.exception.CabNotFoundException;
import com.example.GetRide.exception.CustomerNotFoundException;
import com.example.GetRide.model.Booking;
import com.example.GetRide.model.Cab;
import com.example.GetRide.model.Customer;
import com.example.GetRide.model.Driver;
import com.example.GetRide.repository.BookingRepository;
import com.example.GetRide.repository.CabRepository;
import com.example.GetRide.repository.CustomerRepository;
import com.example.GetRide.repository.DriverRepository;
import com.example.GetRide.transformers.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

//    @Autowired // This is field injection
//    CustomerRepository customerRepository;

    private final CustomerRepository customerRepository;;
//    @Autowired
//    CabRepository cabRepository;

    private final CabRepository cabRepository;
//    @Autowired
//    DriverRepository driverRepository;

    private final DriverRepository driverRepository;

//    @Autowired
//    BookingRepository bookingRepository;

    private final BookingRepository bookingRepository;

    //This is Constructor injection
//    public BookingService(CustomerRepository customerRepository,
//                          CabRepository cabRepository,
//                          DriverRepository driverRepository,
//                          BookingRepository bookingRepository) {
//        this.customerRepository = customerRepository;
//        this.cabRepository = cabRepository;
//        this.driverRepository = driverRepository;
//        this.bookingRepository = bookingRepository;
//    }


    @Autowired
    JavaMailSender javaMailSender;


    public BookingResponse bookCab(BookingRequest bookingRequest) {

        Customer customer = customerRepository.findByEmailId(bookingRequest.getCustomerEmail());
        if(ObjectUtils.isEmpty(customer)) {
            throw new CustomerNotFoundException("Invalid Email ID");
        }

        Optional<Cab> optionalCab = cabRepository.getRandomAvailableCab();
        if(optionalCab.isEmpty()) {
            throw new CabNotFoundException("seems like all the drivers are busy");
        }

        Cab cab = optionalCab.get();
        Driver driver = cab.getDriver();
        cab.setBooked(true);


        //booking entity
        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest,cab);
        booking.setCustomer(customer);
        booking.setDriver(driver);
        Booking savedBooking = bookingRepository.save(booking);



        //set remaining
        customer.getBookings().add(savedBooking);
        cab.getDriver().getBookings().add(savedBooking);


        customerRepository.save(customer); // saves customer + savedBooking
        driverRepository.save(driver); //saves driver + savedBooking

        sendEmail(savedBooking);
        //prepare response dto
        return BookingTransformer.bookingToBookingResponse(savedBooking);
    }

    private void sendEmail(Booking booking) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("naveenpatel42044@gmail.com");
        simpleMailMessage.setTo(booking.getCustomer().getEmailId());
        simpleMailMessage.setSubject("Booking Confirmed!!");
        simpleMailMessage.setText("Congrats! " + booking.getCustomer().getName() +" Your ride is Confirmed! "+
                " Your booking Id is : "+booking.getBookingId());

        javaMailSender.send(simpleMailMessage);
    }
}
