# Báo Cáo Thực Hành: Chẩn Đoán & Khắc Phục 3 Sự Cố Đứt Gãy Pipeline CI/CD Thực Tế

- **Khóa học:** DevOps / Cloud Engineering
- **Bài tập:** Session 12 - Bài 5: Chẩn đoán và khắc phục 3 sự cố đứt gãy Pipeline CI/CD thực tế
- **Đường dẫn nộp bài trên GitHub:** `homework/session_12/ex5/`
- **Học viên:** Hoàng Văn Lương
- **Công nghệ sử dụng:** GitHub Actions, Gradle Wrapper, Docker Buildx, GitHub Container Registry (`ghcr.io`), Linux Ubuntu Runner
- **Tệp tin đính kèm:**
  - [`.github/workflows/broken-pipeline.yml`](.github/workflows/broken-pipeline.yml) (Kịch bản Workflow đã được khắc phục hoàn chỉnh 3 lỗi)
  - [`troubleshooting.md`](troubleshooting.md) (Báo cáo chuyên sâu phân tích log lỗi, nguyên nhân gốc rễ và hướng dẫn khắc phục)
  - [`images/pipeline-green-success.png`](images/pipeline-green-success.png) (Ảnh chụp màn hình kết quả chạy thành công toàn bộ Pipeline - tích xanh)
  - [`Dockerfile`](Dockerfile) (Chỉ dẫn đóng gói ứng dụng Spring Boot JAR)
  - [`build.gradle`](build.gradle) & [`settings.gradle`](settings.gradle) (Cấu hình dự án mẫu)

---

## 1. Tóm Tắt Nhiệm Vụ & Kết Quả Đạt Được

Trong bài thực hành này, kịch bản CI/CD ban đầu (`broken-pipeline.yml`) gặp phải chuỗi 3 sự cố đứt gãy khiến toàn bộ luồng tự động hóa bị dừng lại:
1. **Lỗi 1 (Permission Denied):** Tệp `gradlew` bị từ chối thực thi trên Ubuntu Runner do thiếu cờ `+x` (Exit code 126).
2. **Lỗi 2 (Authentication Failed):** Bước đăng nhập Docker Registry thất bại do truyền sai tên biến Secret (`${{ secrets.REGISTY_TOKEN }}` thay vì `${{ secrets.REGISTRY_TOKEN }}`).
3. **Lỗi 3 (Build Context Error):** Lệnh build Docker Image thất bại do trỏ sai ngữ cảnh thư mục và đường dẫn tệp `Dockerfile`.

Toàn bộ 3 lỗi trên đã được chẩn đoán chi tiết và khắc phục thành công:
- **Trạng thái Pipeline sau khi sửa:** Toàn bộ các Job (`test` và `docker-build`) hoàn thành xuất sắc với trạng thái **Tích xanh (All checks have passed)**.
- Chi tiết báo cáo chẩn đoán, phân tích log lỗi và giải pháp kỹ thuật được trình bày đầy đủ tại [**`troubleshooting.md`**](troubleshooting.md).

---

## 2. Minh Chứng Kết Quả Tích Xanh (Verification)

![Kết quả chạy Pipeline CI/CD đạt trạng thái tích xanh](images/pipeline-green-success.png)
