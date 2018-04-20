package gr.teicm.koala;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "images", schema = "koala") //catalog = "") <-- ??
public class HibernateModel
{
    private int id;
    private String userId;
    private String imageName;
    private byte[] imgData;
    private short height;
    private Short width;
    private String mimeType;
    private Integer fileSize;
    private Double latitude;
    private Double longitude;
    private String cameraBrand;
    private String cameraModel;
    private Timestamp date;
    private Integer megapixels;
    private Short dpi;
    private Double shutterSpeed;
    private Byte flash;
    private Integer fNumber;

    @Id
    @Column(name = "id")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    @Basic
    @Column(name = "image_name")
    public String getImageName()
    {
        return imageName;
    }

    public void setImageName(String imageName)
    {
        this.imageName = imageName;
    }

    @Basic
    @Column(name = "img_data")
    public byte[] getImgData()
    {
        return imgData;
    }

    public void setImgData(byte[] imgData)
    {
        this.imgData = imgData;
    }

    @Basic
    @Column(name = "height")
    public short getHeight()
    {
        return height;
    }

    public void setHeight(short height)
    {
        this.height = height;
    }

    @Basic
    @Column(name = "width")
    public Short getWidth()
    {
        return width;
    }

    public void setWidth(Short width)
    {
        this.width = width;
    }

    @Basic
    @Column(name = "mime_type")
    public String getMimeType()
    {
        return mimeType;
    }

    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    @Basic
    @Column(name = "file_size")
    public Integer getFileSize()
    {
        return fileSize;
    }

    public void setFileSize(Integer fileSize)
    {
        this.fileSize = fileSize;
    }

    @Basic
    @Column(name = "latitude")
    public Double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Double latitude)
    {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public Double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(Double longtitude)
    {
        this.longitude = longtitude;
    }

    @Basic
    @Column(name = "camera_brand")
    public String getCameraBrand()
    {
        return cameraBrand;
    }

    public void setCameraBrand(String cameraBrand)
    {
        this.cameraBrand = cameraBrand;
    }

    @Basic
    @Column(name = "camera_model")
    public String getCameraModel()
    {
        return cameraModel;
    }

    public void setCameraModel(String cameraModel)
    {
        this.cameraModel = cameraModel;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate()
    {
        return date;
    }

    public void setDate(Timestamp date)
    {
        this.date = date;
    }

    @Basic
    @Column(name = "megapixels")
    public Integer getMegapixels()
    {
        return megapixels;
    }

    public void setMegapixels(Integer megapixels)
    {
        this.megapixels = megapixels;
    }

    @Basic
    @Column(name = "dpi")
    public Short getDpi()
    {
        return dpi;
    }

    public void setDpi(Short dpi)
    {
        this.dpi = dpi;
    }

    @Basic
    @Column(name = "shutter_speed")
    public Double getShutterSpeed()
    {
        return shutterSpeed;
    }

    public void setShutterSpeed(Double shutterSpeed)
    {
        this.shutterSpeed = shutterSpeed;
    }

    @Basic
    @Column(name = "flash")
    public Byte getFlash()
    {
        return flash;
    }

    public void setFlash(Byte flash)
    {
        this.flash = flash;
    }

    @Basic
    @Column(name = "f_number")
    public Integer getfNumber()
    {
        return fNumber;
    }

    public void setfNumber(Integer fNumber)
    {
        this.fNumber = fNumber;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HibernateModel hibernateModel = (HibernateModel) o;

        if (id != hibernateModel.id) return false;
        if (height != hibernateModel.height) return false;
        if (userId != null ? !userId.equals(hibernateModel.userId) : hibernateModel.userId != null) return false;
        if (imageName != null ? !imageName.equals(hibernateModel.imageName) : hibernateModel.imageName != null) return false;
        if (!Arrays.equals(imgData, hibernateModel.imgData)) return false;
        if (width != null ? !width.equals(hibernateModel.width) : hibernateModel.width != null) return false;
        if (mimeType != null ? !mimeType.equals(hibernateModel.mimeType) : hibernateModel.mimeType != null) return false;
        if (fileSize != null ? !fileSize.equals(hibernateModel.fileSize) : hibernateModel.fileSize != null) return false;
        if (latitude != null ? !latitude.equals(hibernateModel.latitude) : hibernateModel.latitude != null) return false;
        if (longitude != null ? !longitude.equals(hibernateModel.longitude) : hibernateModel.longitude != null) return false;
        if (cameraBrand != null ? !cameraBrand.equals(hibernateModel.cameraBrand) : hibernateModel.cameraBrand != null) return false;
        if (cameraModel != null ? !cameraModel.equals(hibernateModel.cameraModel) : hibernateModel.cameraModel != null) return false;
        if (date != null ? !date.equals(hibernateModel.date) : hibernateModel.date != null) return false;
        if (megapixels != null ? !megapixels.equals(hibernateModel.megapixels) : hibernateModel.megapixels != null) return false;
        if (dpi != null ? !dpi.equals(hibernateModel.dpi) : hibernateModel.dpi != null) return false;
        if (shutterSpeed != null ? !shutterSpeed.equals(hibernateModel.shutterSpeed) : hibernateModel.shutterSpeed != null) return false;
        if (flash != null ? !flash.equals(hibernateModel.flash) : hibernateModel.flash != null) return false;
        if (fNumber != null ? !fNumber.equals(hibernateModel.fNumber) : hibernateModel.fNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (imageName != null ? imageName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(imgData);
        result = 31 * result + (int) height;
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (mimeType != null ? mimeType.hashCode() : 0);
        result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (cameraBrand != null ? cameraBrand.hashCode() : 0);
        result = 31 * result + (cameraModel != null ? cameraModel.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (megapixels != null ? megapixels.hashCode() : 0);
        result = 31 * result + (dpi != null ? dpi.hashCode() : 0);
        result = 31 * result + (shutterSpeed != null ? shutterSpeed.hashCode() : 0);
        result = 31 * result + (flash != null ? flash.hashCode() : 0);
        result = 31 * result + (fNumber != null ? fNumber.hashCode() : 0);
        return result;
    }
}
