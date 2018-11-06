package test.mvvm.bean;

import java.util.List;

/**
 * Company By SQ
 * Created Date By 2018/11/3 0003
 * Created Time By 上午 9:43
 * Provide Content By MVVM
 * Created by HeBing
 * Provide Content By test.mvvm.bean
 */
public class NewsBean {


    /**
     * date : 20181103
     * stories : [{"images":["https://pic4.zhimg.com/v2-0c1f4be1d1f38ac96bc84009a4983be7.jpg"],"type":0,"id":9700389,"ga_prefix":"110313","title":"天上出现了新的星座，但我怎么找也没看见"},{"images":["https://pic3.zhimg.com/v2-2b18edf8d4d8c9236c4e0ba6d969360e.jpg"],"type":0,"id":9700520,"ga_prefix":"110312","title":"大误 · 于谦父亲的一天"},{"images":["https://pic2.zhimg.com/v2-e5a6db453d4bbfde211d2cfb8592a76d.jpg"],"type":0,"id":9700301,"ga_prefix":"110310","title":"为什么越是专家，越不会说「人话」？"},{"images":["https://pic2.zhimg.com/v2-05c37692ed69a7cf2d6b525ee1bd2099.jpg"],"type":0,"id":9700448,"ga_prefix":"110308","title":"3 岁时发生的流感，免疫系统现在还记得"},{"images":["https://pic2.zhimg.com/v2-2681daf4977122cf823a64863df3cda5.jpg"],"type":0,"id":9700461,"ga_prefix":"110307","title":"如果只有一个鼻孔，我们还能顺畅呼吸吗？"},{"title":"抓住那个漂亮女特务","ga_prefix":"110307","images":["https://pic4.zhimg.com/v2-c10625369a26f34692b01c680b3a0aa7.jpg"],"multipic":true,"type":0,"id":9700297},{"images":["https://pic3.zhimg.com/v2-413430aa0d967bbcc7b7223fea615c52.jpg"],"type":0,"id":9700450,"ga_prefix":"110306","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-f87a27bc225d84a61ff2bb0ee97094c1.jpg","type":0,"id":9700297,"ga_prefix":"110307","title":"抓住那个漂亮女特务"},{"image":"https://pic4.zhimg.com/v2-4be601d3481acf1aebafbf48996d67ab.jpg","type":0,"id":9700512,"ga_prefix":"110216","title":"再见开普勒，感谢你告诉我们不孤独"},{"image":"https://pic4.zhimg.com/v2-918d5a584b3b87201d71f9351d18f82b.jpg","type":0,"id":9700505,"ga_prefix":"110214","title":"重庆坠江公交的黑匣子视频里，司机真的是一气之下反打方向盘吗？"},{"image":"https://pic1.zhimg.com/v2-6b88eee00d84bdc90aee7fb31fb67280.jpg","type":0,"id":9700110,"ga_prefix":"110210","title":"宣讲的人假正经，招聘的人最无情"},{"image":"https://pic2.zhimg.com/v2-1f4cb6cc039be11469474cccecced4b5.jpg","type":0,"id":9699965,"ga_prefix":"110209","title":"未来想看真 · 裸眼 3D，尴尬的光镊是个不错的选择"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-0c1f4be1d1f38ac96bc84009a4983be7.jpg"]
         * type : 0
         * id : 9700389
         * ga_prefix : 110313
         * title : 天上出现了新的星座，但我怎么找也没看见
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-f87a27bc225d84a61ff2bb0ee97094c1.jpg
         * type : 0
         * id : 9700297
         * ga_prefix : 110307
         * title : 抓住那个漂亮女特务
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
