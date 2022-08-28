package com.example.reactordemo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalTime;

class ReactorDemoApplicationTests {

//	@BeforeAll
//	static void init() {
//		ReactorDebugAgent.init();
//	}

	@Test
	void debugTest() {
		int seconds = LocalTime.now().getSecond();
		System.out.println("### " + seconds);

		Mono<Integer> element;

		if (seconds % 2 == 0)
			element = Flux.range(1, 5).elementAt(5);
//					.checkpoint();
		else if (seconds % 3 == 0)
			element = Flux.range(0, 4).elementAt(5);
//					.checkpoint();
		else
			element = Flux.just(1, 2, 3, 4).elementAt(5);
//					.checkpoint();

		element.subscribeOn(Schedulers.parallel()).block();
	}

}
