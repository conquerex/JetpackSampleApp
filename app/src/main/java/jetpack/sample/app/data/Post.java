package jetpack.sample.app.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jongkook on 2020.08.27
 * .
 * REST API Base Url
 * https://jsonplaceholder.typicode.com/
 */
public class Post implements Parcelable {
    private long userId;
    private long id;
    private String title;
    private String body;

    protected Post(Parcel in) {
        userId = in.readLong();
        id = in.readLong();
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public long getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(userId);
        parcel.writeLong(id);
        parcel.writeString(title);
        parcel.writeString(body);
    }
}
