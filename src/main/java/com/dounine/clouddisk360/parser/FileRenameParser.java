package com.dounine.clouddisk360.parser;

import com.dounine.clouddisk360.annotation.Dependency;
import com.dounine.clouddisk360.annotation.Parse;
import com.dounine.clouddisk360.parser.deserializer.file.rename.*;
import com.dounine.clouddisk360.parser.deserializer.login.LoginUserToken;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

@Parse("文件重命名")
@Dependency(depends={AuthTokenParser.class})
public class FileRenameParser extends
		BaseParser<HttpPost, FileRename, FileRenameConst, FileRenameParameter, FileRenameRequestInterceptor, FileRenameResponseHandle, FileRenameParser> {

	public FileRenameParser() {
		super();
	}

	public FileRenameParser(LoginUserToken loginUser) {
		super(loginUser);
	}

	@Override
	public HttpPost initRequest(FileRenameParameter parameter) {
		HttpPost request = new HttpPost(getRequestUri());
		List<NameValuePair> datas = new ArrayList<>(0);
		datas.add(new BasicNameValuePair(CONST.PATH_NAME, parameter.getPath()));
		datas.add(new BasicNameValuePair(CONST.NEWPATH_NAME, parameter.getNewpath()));
		datas.add(new BasicNameValuePair(CONST.NID_NAME, parameter.getNid()));
		datas.add(new BasicNameValuePair(CONST.AJAX_KEY, CONST.AJAX_VAL));
		request.setEntity(new UrlEncodedFormEntity(datas, Consts.UTF_8));
		return request;
	}

}
