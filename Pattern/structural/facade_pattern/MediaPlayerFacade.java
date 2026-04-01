package Pattern.structural.facade_pattern;




public class MediaPlayerFacade {
        private AudioDecoder audioDecoder = new AudioDecoder();
    private VideoRenderer videoRenderer = new VideoRenderer();
    private FileParser fileParser = new FileParser();

    public void play(String file) {
        fileParser.parse(file);
        audioDecoder.decode();
        videoRenderer.render();
    }
}

class AudioDecoder{
    void decode(){
        //implementation
    }
}

class VideoRenderer{
    void render(){
        // implementation
    }
}

class FileParser{
    void parse(String file){
        // implementation
    }
}
