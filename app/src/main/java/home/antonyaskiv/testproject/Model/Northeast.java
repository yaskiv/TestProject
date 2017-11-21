
package home.antonyaskiv.testproject.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "Northeast")
public class Northeast {


    @SerializedName("lat")
    @Expose
    @ColumnInfo(name = "lat_n")
    private Double lat;
    @SerializedName("lng")
    @Expose
    @ColumnInfo(name = "lng_n")
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

}
