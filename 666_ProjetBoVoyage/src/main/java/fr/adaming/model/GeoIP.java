package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="geoLocations")
public class GeoIP {
	
	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_geo")
	private int idGeo;
	private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;
    
    
    //contructeur
	public GeoIP() {
		super();
	}

	public GeoIP(String ipAddress, String city, String latitude, String longitude) {
		super();
		this.ipAddress = ipAddress;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public GeoIP(int idGeo, String ipAddress, String city, String latitude, String longitude) {
		super();
		this.idGeo = idGeo;
		this.ipAddress = ipAddress;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	//getter et setter
	public int getIdGeo() {
		return idGeo;
	}

	public void setIdGeo(int idGeo) {
		this.idGeo = idGeo;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	//ToString
	@Override
	public String toString() {
		return "GeoIP [idGeo=" + idGeo + ", ipAddress=" + ipAddress + ", city=" + city + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
    
    

}
