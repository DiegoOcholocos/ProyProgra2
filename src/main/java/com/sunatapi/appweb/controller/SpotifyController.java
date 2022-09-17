package com.sunatapi.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sunatapi.appweb.integration.api.SpotifyAPI;
import com.sunatapi.appweb.integration.dto.*;

import org.springframework.ui.Model;

@Controller
public class SpotifyController {
    
    private static final String HOME_INDEX ="spotify/index";
    private final SpotifyAPI spotifyAPI;
    
    public SpotifyController(SpotifyAPI spotifyAPI){
        this.spotifyAPI = spotifyAPI;
    }

    @GetMapping("/spotify/index")
    public String index(Model model) {
        UserSpotify me =spotifyAPI.me();   
        model.addAttribute("me",me);
        return HOME_INDEX;
    }
}
