package composite.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IDirectory {

	private String name;
	private List<IDirectory> files;

	public Folder(String name) {
		this.name = name;
		this.files = new ArrayList<>();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getExtension() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> validate(Filter filter) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		for (IDirectory file : files) {
			List<String> subFiles = file.validate(filter);
			result.addAll(subFiles);
		}
		return result;
	}

}
