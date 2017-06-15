package info.example.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@RequestScoped
public class ImageBean
{

	public static final int MAX_IMAGE_COUNT = 15;
	private static final Logger logger = LoggerFactory.getLogger(ImageBean.class);
	private List<Photo> images;

	public ImageBean()
	{
		images = new ArrayList<Photo>();
		
		for (int ctr = 0; ctr < MAX_IMAGE_COUNT; ctr++)
		{
			Photo photo = new Photo();
			photo.setId(ctr);
			photo.setTitle("Mock Title #" + ctr);
			String description = "This photo is used to represent item #" + ctr + " in a selection of images."; 
			photo.setDescription(description);
			images.add(photo);
			logger.info("Added Photo {} to collection.", ctr);
		}
	}

	public List<Photo> getImages()
	{
		return images;
	}

	public void setImages(List<Photo> images)
	{
		this.images = images;
	}

}
