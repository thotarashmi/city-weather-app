package com.weather.region.dto;

import lombok.Data;

@Data
public class ResponseDto<R> {
    R data;
}
