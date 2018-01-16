/**
 * 调用后台批量删除的方法
 */
function deleteBatch() {
	/*要提交的值一定要位于id为form的范围之下*/
	$("#form").attr("action","DeleteBatchServlet");
	$("#form").submit();
}

function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#form").submit();
}