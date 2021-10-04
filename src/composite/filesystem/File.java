package composite.filesystem;

import java.util.ArrayList;
import java.util.List;

public class File implements IDirectory {

	private String name;
	private String extension;
	private Integer fileSize;

	public File(String name, String extension, Integer fileSize) {
		this.name = name;
		this.extension = extension;
		this.fileSize = fileSize;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public Integer getSize() {
		// TODO Auto-generated method stub
		return this.fileSize;
	}

	@Override
	public List<String> validate(Filter filter) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		if (filter.apply(this)) {
			result.add(name + "." + extension);
		}
		return result;
	}

	@Override
	public String getExtension() {
		// TODO Auto-generated method stub
		return this.extension;
	}

}
