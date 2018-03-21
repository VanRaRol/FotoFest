package com.example.oriolqa.foto_fest;


/**
 * Created by Oriol on 10/03/2018.
 */


class Events {
    String event;
    String location;
    int photoId;
    int button;


    Events(String event, String location, int photoId, int button) {
        this.event = event;
        this.location = location;
        this.photoId = photoId;
        this.button = button;

    }
}

