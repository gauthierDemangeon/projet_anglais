class I {
	int i=3;
	I() {
		this.i();
		}
	int i() {
		return i++;
		}
	}
class Main extends I {
	int i=5;
	int i() {
		return i+super.i();
		}
	private boolean i(int a){return true;}
	public static void main(String[] i) {}
	}