package composite.filesystem;

public class ExtensionFilter implements Filter {
	
	private String extension;
	
	public ExtensionFilter(String extension) {
		this.extension = extension;
	}
	
	public boolean apply(IDirectory file) {
		return file.getExtension().equals(extension);
	}
	
}
