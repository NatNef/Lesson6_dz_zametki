package keyone.keytwo.lesson6_dz_zametki;

import android.os.Parcel;
import android.os.Parcelable;


    public class Menu implements Parcelable {

        protected Menu(int imageIndex, String name) {
            this.imageIndex = imageIndex;
            this.name = name;
        }


        protected Menu(Parcel in) {
            imageIndex = in.readInt();
            name = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(imageIndex);
            dest.writeString(name);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Menu> CREATOR = new Creator<Menu>() {
            @Override
            public Menu createFromParcel(Parcel in) {
                return new Menu(in);
            }

            @Override
            public Menu[] newArray(int size) {
                return new Menu[size];
            }
        };

        public int getImageIndex() {
            return imageIndex;
        }

        public String getName() {
            return name;
        }

        private int imageIndex;
        private String name;

        public Menu(String name) {
            this.name = name;
        }


        public void setImageIndex(int imageIndex) {
            this.imageIndex = imageIndex;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
