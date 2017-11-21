
package home.antonyaskiv.testproject.Model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "Geometry")
public class Geometry {


    @SerializedName("location")
    @Expose
    @Embedded
    private Location location;
    @SerializedName("viewport")
    @Expose
    @Embedded
    private Viewport viewport;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

}
