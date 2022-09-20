package _helpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

public class MySoftAssert extends SoftAssert {
	Logger log = Logger.getLogger(this.getClass());

	private enum AssertResultType {
		ERROR, SUCCESS;
	}

	protected PropsReader config = new PropsReader("config.properties");

	private class AssertResult {
		private String message;
		private AssertResultType resultType;

		public AssertResult(AssertResultType resultType, String message) {
			setMessage(message);
			setResultType(resultType);
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public AssertResultType getResultType() {
			return resultType;
		}

		public void setResultType(AssertResultType resultType) {
			this.resultType = resultType;
		}
	}

	private List<AssertResult> results;

	public MySoftAssert() {
		super();
		results = new ArrayList<AssertResult>();
	}

	public void assertTrue(boolean conditions, String negativeMessage, String positiveMessage)
			throws AssertionError, IOException {
		super.assertTrue(conditions, positiveMessage);
		doAssert(conditions, negativeMessage, positiveMessage);
	}


	public void assertNull(Object object, String negativeMessage, String positiveMessage)
			throws AssertionError, IOException {
		super.assertNull(object);
		doAssert(object == null, negativeMessage, positiveMessage);
	}

	public void assertFalse(boolean conditions, String negativeMessage, String positiveMessage)
			throws AssertionError, IOException {
		super.assertFalse(conditions);
		doAssert(!conditions, negativeMessage, positiveMessage);
	}

	public void assertFalse2(boolean conditions, String negativeMessage, String positiveMessage) {
		super.assertFalse(conditions);
		try {
			doAssert(!conditions, negativeMessage, positiveMessage);
		} catch (AssertionError e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fail() {
		super.fail();
	}

//	private void doAssert(boolean conditions, String negativeMessage, String positiveMessage)
//			throws AssertionError, IOException {
//		if (conditions) {
//			results.add(new AssertResult(AssertResultType.SUCCESS, positiveMessage));
//		} else {
//			results.add(new AssertResult(AssertResultType.ERROR, negativeMessage));
//		}
//	}
	
	private void doAssert(boolean conditions, String negativeMessage, String positiveMessage)
			throws AssertionError, IOException {
		if (conditions) {
			results.add(new AssertResult(AssertResultType.SUCCESS,  positiveMessage));
			System.out.println(positiveMessage);
		} else {
			results.add(new AssertResult(AssertResultType.ERROR, negativeMessage));
			System.out.println("Error: "+negativeMessage);
		}
	}


	public void assertEquals(String actual, String expected, String position) {
		super.assertEquals(actual, expected);
		String message = position + " Actual: " + actual + " Expected: " + expected;
		try {
			doAssert(actual != null && actual.equals(expected), message, message);
		} catch (AssertionError | IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void assertAll() {
		StringBuilder testReult = new StringBuilder();
		for (AssertResult result : results) {
			if (result.getResultType() == AssertResultType.ERROR) {
				testReult.append("[");
				testReult.append(result.getResultType());
				testReult.append("] - ");
				testReult.append(result.getMessage());
				testReult.append(";\n");
			}

		}
		if (testReult.length() != 0) {
			throw new AssertionError(testReult.toString());
		}
	}
}
