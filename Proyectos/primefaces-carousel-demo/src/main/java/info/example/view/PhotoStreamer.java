package info.example.view;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@RequestScoped
public class PhotoStreamer
{

	private static final Logger logger = LoggerFactory.getLogger(PhotoStreamer.class);
	private static StreamedContent defaultFileContent;
	private StreamedContent fileContent;

	public StreamedContent getFileContent()
	{
		logger.trace("Entered method getFileContent.");
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String photoId = externalContext.getRequestParameterMap().get("photo_id");
		if(photoId  == null || photoId.equals(""))
		{
			fileContent = defaultFileContent;
			logger.info("Id was null or empty. Retrieved default file content.");
		}
		else
		{
			int parsedId = Integer.parseInt(photoId);
			if(parsedId < 0 || parsedId > ImageBean.MAX_IMAGE_COUNT)
			{
				fileContent = defaultFileContent;
				logger.info("Invalid Id. Retrieved default file content.");
			}
			ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
			InputStream inputStream = contextClassLoader.getResourceAsStream("resources/images/Photo - " + parsedId + ".png");
			fileContent = new DefaultStreamedContent(inputStream, "image/png");
			logger.info("Retrieved file content for image {}.", parsedId);
		}
		logger.trace("Exited method getFileContent.");
		return fileContent;
	}

	public void setFileContent(StreamedContent fileContent)
	{
		this.fileContent = fileContent;
	}
	
	static
	{
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = contextClassLoader.getResourceAsStream("resources/images/Photo - 0.png");
		defaultFileContent = new DefaultStreamedContent(inputStream, "image/png");
	}
	
}
