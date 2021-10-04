package composite.filesystem;

import java.util.List;

public interface IDirectory {
	
	String getName();
	
	String getExtension();
	
	Integer getSize();
	
	List<String> validate(Filter filter);

}
