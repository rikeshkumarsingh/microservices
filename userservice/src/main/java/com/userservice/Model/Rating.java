package com.userservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
	
	private String rateid;
	private String userid;
	private String hotelid;
    private  int rating;
    private  String feedback;
    
    private Hotels hotels;

}
