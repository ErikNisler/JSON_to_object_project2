package projekt2.engeto.com;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class State {
    @JsonProperty("country")
    private String country;
    @JsonProperty("standard_rate")
    private Double standardRate;
    @JsonProperty("reduced_rate")
    private Object reducedRate;
    @JsonProperty("reduced_rate_alt")
    private Object reduceRateAlt;
    @JsonProperty("super_reduced_rate")
    private Object superReducedRate;
    @JsonProperty("parking_rate")
    private Object parkingRate;
    @JsonProperty("_comment")
    private String comment;
    @JsonProperty("iso_duplicate_of")
    private String isoDuplicateOf;

    public State(){}

    public State(String country, Double standardRate, Object reducedRate, Object reduceRateAlt, Object parkingRate, String comment, String isoDuplicateOf) {
        this.country = country;
        this.standardRate = standardRate;
        this.reducedRate = reducedRate;
        this.reduceRateAlt = reduceRateAlt;
        this.parkingRate = parkingRate;
        this.comment = comment;
        this.isoDuplicateOf = isoDuplicateOf;
    }

    public Object getSuperReducedRate() {
        return superReducedRate;
    }

    public void setSuperReducedRate(Object superReducedRate) {

        this.superReducedRate = superReducedRate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(Double standardRate) {
        this.standardRate = standardRate;
    }

    public Object getReducedRate() {
        return reducedRate;
    }

    public void setReducedRate(Object reducedRate) {
        this.reducedRate = reducedRate;
    }

    public Object getReduceRateAlt() {
        return reduceRateAlt;
    }

    public void setReduceRateAlt(Object reduceRateAlt) {
        this.reduceRateAlt = reduceRateAlt;
    }

    public Object getParkingRate() {
        return parkingRate;
    }

    public void setParkingRate(Object parkingRate) {
        this.parkingRate = parkingRate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIsoDuplicateOf() {
        return isoDuplicateOf;
    }

    public void setIsoDuplicateOf(String isoDuplicateOf) {
        this.isoDuplicateOf = isoDuplicateOf;
    }

    @Override
    public String toString() {
        return "country='" + country + '\'' +
                ", standardRate=" + standardRate +
                ", reducedRate=" + reducedRate +
                ", superReducedRate=" + superReducedRate +
                ", reduceRateAlt=" + reduceRateAlt +
                ", parkingRate=" + parkingRate +
                ", comment='" + comment + '\'' +
                ", isoDuplicateOf='" + isoDuplicateOf + '\'' +
                '}';
    }


}
