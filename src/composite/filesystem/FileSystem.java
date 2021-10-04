package composite.filesystem;

import java.util.List;

public class FileSystem {
	
	private IDirectory root;
	
	public FileSystem() {
		this.root = new Folder("root");
	}
	
	public List<String> getFiles(Filter filter) {
		List<String> result = this.root.validate(filter);
		return result;
	}

}
