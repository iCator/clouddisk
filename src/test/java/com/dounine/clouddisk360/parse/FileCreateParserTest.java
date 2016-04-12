package com.dounine.clouddisk360.parse;

import com.dounine.clouddisk360.parser.FileCreateParser;
import com.dounine.clouddisk360.parser.deserializer.file.create.FileCreate;
import com.dounine.clouddisk360.parser.deserializer.file.create.FileCreateParameter;
import com.dounine.clouddisk360.parser.deserializer.login.LoginUserToken;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileCreateParserTest extends TestCase {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileCreateParserTest.class);

	public void testParse() {
		LoginUserToken loginUserToken = TestUser.LOGIN_USER_TOKEN;

		FileCreateParser fileCreateParser = new FileCreateParser(loginUserToken);
		FileCreateParameter fileCreateParameter = new FileCreateParameter();
		fileCreateParameter.setPath("/lake/你好");
		FileCreate fileCreate = fileCreateParser.parse(fileCreateParameter);

		LOGGER.info(fileCreate.toString());
	}
}
