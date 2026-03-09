package com.insta.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix="polar")
@Getter
@Setter
public class PolarProp {

	public String greeting;
}
