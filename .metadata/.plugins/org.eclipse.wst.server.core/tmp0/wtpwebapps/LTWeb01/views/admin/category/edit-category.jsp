<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa Category</title>
    <style>
        .form-container { max-width: 600px; margin: 50px auto; padding: 20px; border: 1px solid #ddd; border-radius: 8px; }
        .form-group { margin-bottom: 20px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="file"] { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; }
        .btn { padding: 10px 20px; text-decoration: none; border-radius: 4px; border: none; cursor: pointer; margin-right: 10px; }
        .btn-primary { background-color: #28a745; color: white; }
        .btn-warning { background-color: #ffc107; color: black; }
        .btn-secondary { background-color: #6c757d; color: white; }
        .current-image { text-align: center; margin: 20px 0; padding: 15px; border: 1px solid #ddd; border-radius: 4px; }
        .current-image img { max-width: 150px; max-height: 150px; }
        .preview { margin-top: 10px; }
        .preview img { max-width: 100px; max-height: 100px; border: 1px solid #ddd; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Chỉnh sửa Category</h2>
        <a href="${pageContext.request.contextPath}/categories.do" style="margin-bottom: 20px; display: inline-block;">← Quay lại</a>
        
        <form action="${pageContext.request.contextPath}/admin/category/edit/${category.id}" method="post" enctype="multipart/form-data">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="cateId" value="${categor.id}">
            
            <div class="form-group">
                <label>Tên Category (*)</label>
                <input type="text" name="cateName" value="${category.name}" required 
                       maxlength="255">
            </div>
            
            <c:if test="${not empty category.icon}">
                <div class="current-image">
                    <h4>Ảnh hiện tại:</h4>
					<img src="${pageContext.request.contextPath}/images/${category.icon}"  alt="${category.name}" style="width:100px;height:100px;">
                    <p><small>${category.icon}</small></p>
                </div>
            </c:if>
            
            <div class="form-group">
                <label>Thay ảnh mới (Tùy chọn)</label>
                <input type="file" name="file" accept="image/*" onchange="previewImage(event)">
                <div id="preview" class="preview"></div>
                <small style="color: #666;">Để trống để giữ ảnh hiện tại</small>
            </div>
            
            <div>
                <button type="submit" class="btn btn-warning">Cập nhật</button>
                <a href="${pageContext.request.contextPath}/categories.do" class="btn btn-secondary">Hủy</a>
            </div>
        </form>
    </div>

    <script>
        function previewImage(event) {
            const file = event.target.files[0];
            const preview = document.getElementById('preview');
            
            if (file) {
                if (file.size > 5 * 1024 * 1024) {
                    alert('File quá lớn! Tối đa 5MB');
                    event.target.value = '';
                    return;
                }
                
                const reader = new FileReader();
                reader.onload = function(e) {
                    preview.innerHTML = '<img src="' + e.target.result + '">';
                }
                reader.readAsDataURL(file);
            } else {
                preview.innerHTML = '';
            }
        }
    </script>
</body>
</html>
