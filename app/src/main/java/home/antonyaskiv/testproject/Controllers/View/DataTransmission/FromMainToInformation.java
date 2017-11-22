package home.antonyaskiv.testproject.Controllers.View.DataTransmission;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by AntonYaskiv on 22.11.2017.
 */

public class FromMainToInformation implements Parcelable {
    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public String getUri() {
        return Uri;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    private Double lat;
    private Double lng;
    private String Uri;
    private String name;
    private String address;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.lat);
        dest.writeDouble(this.lng);
        dest.writeString(this.Uri);
        dest.writeString(this.name);
        dest.writeString(this.address);
    }

    public FromMainToInformation() {
    }

    public FromMainToInformation(Double lat, Double lng, String uri, String name, String address) {
        this.lat = lat;
        this.lng = lng;
        Uri = uri;
        this.name = name;
        this.address = address;
    }

    protected FromMainToInformation(Parcel in) {
        this.lat = in.readDouble();
        this.lng = in.readDouble();
        this.Uri = in.readString();
        this.name = in.readString();
        this.address = in.readString();
    }

    public static final Parcelable.Creator<FromMainToInformation> CREATOR = new Parcelable.Creator<FromMainToInformation>() {
        @Override
        public FromMainToInformation createFromParcel(Parcel source) {
            return new FromMainToInformation(source);
        }

        @Override
        public FromMainToInformation[] newArray(int size) {
            return new FromMainToInformation[size];
        }
    };
}
