package composite.filesystem;

public class SizeFilter implements Filter {

	private int limit;
	private OperatorType opType;

	public SizeFilter(int limit, OperatorType type) {
		this.limit = limit;
		this.opType = type;
	}

	@Override
	public boolean apply(IDirectory file) {
		// TODO Auto-generated method stub
		if (this.opType == OperatorType.e) {
			return file.getSize() == this.limit;
		} else if (this.opType == OperatorType.g) {
			return file.getSize() > this.limit;
		} else if (this.opType == OperatorType.l) {
			return file.getSize() < this.limit;
		} else if (this.opType == OperatorType.le) {
			return file.getSize() <= this.limit;
		} else if (this.opType == OperatorType.ge) {
			return file.getSize() >= this.limit;
		}
		return false;
	}

}
