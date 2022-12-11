import com.example

def call(String ImageName, String Version) {
    return new Docker(this).buildDockerImage(ImageName, Version)
}
