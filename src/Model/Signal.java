package Model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Signal extends Observer{
    int count;
    int start;
    String file;
    Media sound;
    MediaPlayer mediaPlayer;
    Boolean state;
    public Signal(Subject subject)
    {
        this.count = 0;
    this.state = false;
    this.start = subject.getState();
    this.file = "viva.wav";
    this.sound = new Media(new File(file).toURI().toString());
    this.mediaPlayer = new MediaPlayer(sound);
    this.subject = subject;
    this.subject.attach(this);
    }
    public void onComp(int count)
    { this.count = count;
    this.start = subject.getState();
    this.state = true;
    }
    public void offComp(){
        this.state = false; mediaPlayer.stop();
    }
    public void delComo(Subject st){
        mediaPlayer.stop();
        st.detach(this);
    }
    @Override
        public void update(Subject st) {
        if (state)
        { if (st.getState() == start + count)
      {
          mediaPlayer.play();
          start += count;
      }
          if (st.getState() == start + 2)
          { mediaPlayer.stop();}
        }
 }
}


