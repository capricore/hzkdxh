/**
* Json���ݽ�����:���ڽ����ӷ���˷��ص�JSON������Ϣ,���������ֶΣ�
  result:��Ӧ�����boolean��
  message�����ص���Ϣ
  userData�����ص��û�����
*/
function JsonRespUtils(jsonDoc){
	if (jsonDoc==null || jsonDoc=="") {
	    alert("�Ƿ�����Ӧ����!");
	    return;
	}
	this.jsonObj = eval('('+jsonDoc+')');
}

JsonRespUtils.prototype={
    //��Ӧ����Ƿ�ɹ�
    isSuccessfully:function(){
	    return this.jsonObj.result;
    },
    //�õ����ص���Ϣ
    getMessage:function(){
    	return this.jsonObj.message;
    },
    //�õ����ص��û�����
    getCustomData:function(){
    	return this.jsonObj.customData;
    }
}