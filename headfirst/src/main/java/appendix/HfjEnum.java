package headfirst.appendix;


public class HfjEnum {
	
	enum Names {

		JERRY("lead guitar"){
			public String sings(){
				return "hoarsely";
			}
		},
		PHIL("bass");

		private String instrument;
		Names(String ins){
			this.instrument = ins;
		}
		public String getInstrument(){
			return this.instrument;
		}
		public String sings(){
			return "occa";
		}
	}

	public static void main(String[] args){
		for (Names n : Names.values()){
			System.out.println(n + "--instrument--" + n.getInstrument() + "--sings: " + n.sings());
		}
	}

}
