package id.havanah.app.poetrify.data;

import java.util.Arrays;
import java.util.List;

import id.havanah.app.poetrify.model.Feed;

/**
 * Created by farhan at 0:37
 * on 30/10/2019.
 * Havanah Team, ID.
 */
public class DummyData {
  public static Feed[] getFeedList() {
    Feed[] feeds = {
        new Feed("https://images.unsplash.com/photo-1572276160886-98183e5121b5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80",
            "https://i.ibb.co/2KrNHcS/Whats-App-Image-2019-11-01-at-10-20-18-PM.jpg",
            "Park Han",
            "211",
            "Happy b'day :)",
            "Pic by Unsplash",
            "29 Oktober 2019",
            null),
        new Feed("https://images.unsplash.com/photo-1572276160886-98183e5121b5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80",
            "https://images.unsplash.com/photo-1571423039463-fd8a8b93b33e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "Park Han",
            "141",
            "Realm the soul",
            "Pic by Unsplash",
            "12 Mei 2019",
            null),
        new Feed("https://images.unsplash.com/photo-1572276160886-98183e5121b5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80",
            "https://images.unsplash.com/photo-1553728131-deadabc0517c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80",
            "Park Han",
            "156",
            "",
            "Pic by Unsplash",
            "15 Desember 2018",
            "16 Desember 2018"),
        new Feed("https://images.unsplash.com/photo-1572276160886-98183e5121b5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80",
            "https://images.unsplash.com/photo-1571993192866-202f70b7ec7e?ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=80",
            "Park Han",
            "126",
            "Realm the soul",
            "Pic by Unsplash",
            "17 Agustus 2018",
            null),
        new Feed("https://images.unsplash.com/photo-1572276160886-98183e5121b5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80",
            "https://images.unsplash.com/photo-1570810775100-b0809c777122?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "Park Han",
            "169",
            "Realm the soul",
            "Pic by Unsplash",
            "12 Mei 2018",
            "16 Mei 2018"),
    };
    return feeds;
  }
}
