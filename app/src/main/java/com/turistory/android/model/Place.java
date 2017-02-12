package com.turistory.android.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by cristobal on 12/02/17.
 */
@Entity(indexes = {
        @Index(value = "name DESC", unique = true)
})
public class Place {
    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;

    @Generated(hash = 1925960893)
    public Place(Long id, @NotNull String name, @NotNull String description,
                 @NotNull Double latitude, @NotNull Double longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Generated(hash = 1170019414)
    public Place() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
