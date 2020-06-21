package com.example.reservationservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routes(ReservationRepository rr) {
		return route()
				.GET("/reservations", serverRequest -> ServerResponse.ok().body(rr.findAll(), Reservation.class))
				.build();
	}
}

interface ReservationRepository extends ReactiveCrudRepository<Reservation, Integer> {

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Reservation {

	@Id
	private Integer id;
	private String name;
}

