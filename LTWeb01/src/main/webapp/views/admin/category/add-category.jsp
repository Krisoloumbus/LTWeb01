<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Category</title>
    <style>
        .form-container { max-width: 600px; margin: 50px auto; padding: 20px; border: 1px solid #ddd; border-radius: 8px; }
        .form-group { margin-bottom: 20px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="file"] { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; }
        .btn { padding: 10px 20px; text-decoration: none; border-radius: 4px; border: none; cursor: pointer; }
        .btn-primary { background-color: #007bff; color: white; }
        .btn-secondary { background-color: #6c757d; color: white; }
        .preview { margin-top: 10px; }
        .preview img { max-width: 100px; max-height: 100px; border: 1px solid #ddd; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Thêm Category Mới</h2>
        
        <form action="${pageContext.request.contextPath}/admin/category/add" method="post" enctype="multipart/form-data">
            
            
            <div class="form-group">
                <label>Tên Category (*)</label>
                <input type="text" name="cateName" required 
                       placeholder="Nhập tên category..." maxlength="255">
            </div>
            
            <div class="form-group">
                <label>Icon (Ảnh)</label>
                <input type="file" name="file" accept="image/*" onchange="previewImage(event)">
                <div id="preview" class="preview"></div>
                <small style="color: #666;">Chọn ảnh JPG, PNG (tối đa 5MB)</small>
            </div>
            
            <div>
                <button type="submit" class="btn btn-primary">Lưu Category</button>
                <a href="${pageContext.request.contextPath}/admin/category/" class="btn btn-secondary">Hủy</a>
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
