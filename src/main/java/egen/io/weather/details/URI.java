package egen.io.weather.details;

public class URI {

public static final String WEATHER="{weather}";
	
	public static final String CITY ="{city}";

	public static final String PRO="{city}/{property}";
	
	public static final String AVG="{city}/average/{duration}/{property}";
}

//http://localhost:8080/myweather/weather---> FEED DATA
//http://localhost:8080/myweather/weather/city/ ----> for total number of cities
//http://localhost:8080/myweather/weather/city/property---> FOR PARTICULAR FILED
//http://localhost:8080/myweather/weather/city/average/hourly/property---> FOR hourly avg
//http://localhost:8080/myweather/weather/city/average/daily/property---> for daily avg
