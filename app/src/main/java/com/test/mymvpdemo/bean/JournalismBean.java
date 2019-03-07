package com.test.mymvpdemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class JournalismBean implements Parcelable {
    public List<ChildData> tech;
    public List<ChildData> auto;
    public List<ChildData> money;
    public List<ChildData> sports;
    public List<ChildData> dy;
    public List<ChildData> war;
    public List<ChildData> ent;
    public List<ChildData> toutiao;

    public static class ChildData implements Parcelable {
        public Object liveInfo;
        public int tcount;
        public String docid;
        public Object videoInfo;
        public String channel;
        public String link;
        public String source;
        public String title;
        public String type;
        public Object imgsrcFrom;
        public int imgsrc3gtype;
        public String unlikeReason;
        public Object isTop;
        public String digest;
        public String typeid;
        public Object addata;
        public String tag;
        public String category;
        public String ptime;
        public List<PicInfoBean> picInfo;

        public static class PicInfoBean {

            public Object ref;
            public Object width;
            public String url;
            public Object height;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable((Parcelable) this.liveInfo, flags);
            dest.writeInt(this.tcount);
            dest.writeString(this.docid);
            dest.writeParcelable((Parcelable) this.videoInfo, flags);
            dest.writeString(this.channel);
            dest.writeString(this.link);
            dest.writeString(this.source);
            dest.writeString(this.title);
            dest.writeString(this.type);
            dest.writeParcelable((Parcelable) this.imgsrcFrom, flags);
            dest.writeInt(this.imgsrc3gtype);
            dest.writeString(this.unlikeReason);
            dest.writeParcelable((Parcelable) this.isTop, flags);
            dest.writeString(this.digest);
            dest.writeString(this.typeid);
            dest.writeParcelable((Parcelable) this.addata, flags);
            dest.writeString(this.tag);
            dest.writeString(this.category);
            dest.writeString(this.ptime);
            dest.writeList(this.picInfo);
        }

        public ChildData() {
        }

        protected ChildData(Parcel in) {
            this.liveInfo = in.readParcelable(Object.class.getClassLoader());
            this.tcount = in.readInt();
            this.docid = in.readString();
            this.videoInfo = in.readParcelable(Object.class.getClassLoader());
            this.channel = in.readString();
            this.link = in.readString();
            this.source = in.readString();
            this.title = in.readString();
            this.type = in.readString();
            this.imgsrcFrom = in.readParcelable(Object.class.getClassLoader());
            this.imgsrc3gtype = in.readInt();
            this.unlikeReason = in.readString();
            this.isTop = in.readParcelable(Object.class.getClassLoader());
            this.digest = in.readString();
            this.typeid = in.readString();
            this.addata = in.readParcelable(Object.class.getClassLoader());
            this.tag = in.readString();
            this.category = in.readString();
            this.ptime = in.readString();
            this.picInfo = new ArrayList<PicInfoBean>();
            in.readList(this.picInfo, PicInfoBean.class.getClassLoader());
        }

        public static final Creator<ChildData> CREATOR = new Creator<ChildData>() {
            @Override
            public ChildData createFromParcel(Parcel source) {
                return new ChildData(source);
            }

            @Override
            public ChildData[] newArray(int size) {
                return new ChildData[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.tech);
        dest.writeList(this.auto);
        dest.writeList(this.money);
        dest.writeList(this.sports);
        dest.writeList(this.dy);
        dest.writeList(this.war);
        dest.writeList(this.ent);
        dest.writeList(this.toutiao);
    }

    public JournalismBean() {
    }

    protected JournalismBean(Parcel in) {
        this.tech = new ArrayList<ChildData>();
        in.readList(this.tech, ChildData.class.getClassLoader());
        this.auto = new ArrayList<ChildData>();
        in.readList(this.auto, ChildData.class.getClassLoader());
        this.money = new ArrayList<ChildData>();
        in.readList(this.money, ChildData.class.getClassLoader());
        this.sports = new ArrayList<ChildData>();
        in.readList(this.sports, ChildData.class.getClassLoader());
        this.dy = new ArrayList<ChildData>();
        in.readList(this.dy, ChildData.class.getClassLoader());
        this.war = new ArrayList<ChildData>();
        in.readList(this.war, ChildData.class.getClassLoader());
        this.ent = new ArrayList<ChildData>();
        in.readList(this.ent, ChildData.class.getClassLoader());
        this.toutiao = new ArrayList<ChildData>();
        in.readList(this.toutiao, ChildData.class.getClassLoader());
    }

    public static final Parcelable.Creator<JournalismBean> CREATOR = new Parcelable.Creator<JournalismBean>() {
        @Override
        public JournalismBean createFromParcel(Parcel source) {
            return new JournalismBean(source);
        }

        @Override
        public JournalismBean[] newArray(int size) {
            return new JournalismBean[size];
        }
    };
}
