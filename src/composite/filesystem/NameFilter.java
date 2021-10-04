package composite.filesystem;

public class NameFilter implements Filter {
	
	private String name;
	
	public NameFilter(String name) {
		this.name = name;
	}

	@Override
	public boolean apply(IDirectory file) {
		// TODO Auto-generated method stub
		return file.getName().equals(name);
	}
	
}
