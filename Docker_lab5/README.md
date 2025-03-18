# 2104631 - Trần Thị Thúy Vy 

## 1.Kiểm tra phiên bản Docker
`docker --version`  
Hiển thị phiên bản Docker đang cài đặt trên hệ thống.
![img_1.png](img_1.png)

## 2. Chạy container thử nghiệm
`docker run hello-world`  
Chạy một container kiểm tra, hiển thị thông báo xác nhận Docker hoạt động đúng.
![img_2.png](img_2.png)
## 3. Tải image nginx từ Docker Hub
`docker pull nginx`  
Tải image `nginx` về máy cục bộ.
![img_3.png](img_3.png)

## 4. Liệt kê các images đã tải
`docker images`  
Hiển thị danh sách các images trên máy.
![img_4.png](img_4.png)

## 5. Chạy container nginx dưới nền
`docker run -d nginx`  
Chạy `nginx` trong chế độ nền (detached mode).
![img_5.png](img_5.png)
## 6. Xem danh sách container đang chạy
`docker ps`  
Hiển thị danh sách các container đang hoạt động.
![img_6.png](img_6.png)

## 7. Xem danh sách tất cả container (kể cả đã dừng)
`docker ps -a`  
Hiển thị toàn bộ container, bao gồm cả những container đã dừng.
![img_7.png](img_7.png)

## 8. Xem logs của container
`docker logs <container_id>`  
Xem nhật ký (logs) của một container cụ thể.
![img_8.png](img_8.png)

## 9. Truy cập vào bên trong container
`docker exec -it <container_id> /bin/sh`  
Mở terminal bên trong container để thực hiện các lệnh.
![img_9.png](img_9.png)

## 10. Dừng container
`docker stop <container_id>`  
Dừng một container đang chạy.
![img_10.png](img_10.png)

## 11. Khởi động lại container
`docker restart <container_id>`  
Khởi động lại container.
![img_11.png](img_11.png)

## 12. Xóa container
`docker rm <container_id>`  
Xóa một container đã dừng.
![img_12.png](img_12.png)
## 13. Xóa tất cả container đã dừng
`docker container prune`  
Xóa toàn bộ container không hoạt động.
![img_13.png](img_13.png)

## 14. Xóa image
`docker rmi <image_id>`  
Xóa một image khỏi hệ thống.
![img_14.png](img_14.png)

## 15. Xóa tất cả images không sử dụng
`docker image prune -a`  
Dọn dẹp toàn bộ images không sử dụng để tiết kiệm dung lượng.
![img_15.png](img_15.png)

## 16. Chạy container và ánh xạ cổng
`docker run -d -p 8080:80 nginx`  
Chạy container nginx và ánh xạ cổng 8080 trên máy host với cổng 80 của container.
![img_16.png](img_16.png)

## 17. Xem thông tin chi tiết của container
`docker inspect <container_id>`  
Hiển thị thông tin chi tiết về container dưới dạng JSON.
![img_17.png](img_17.png)

## 18. Tạo volume và gắn vào container
`docker run -d -v mydata:/data nginx`  
Tạo một volume tên `mydata` và gắn vào `/data` trong container.
![img_18.png](img_18.png)

## 19. Liệt kê danh sách volumes
`docker volume ls`  
Hiển thị danh sách các volumes trên hệ thống.
![img_19.png](img_19.png)

## 20. Xóa tất cả volumes không sử dụng
`docker volume prune`  
Dọn dẹp toàn bộ volumes không sử dụng.
![img_20.png](img_20.png)

## 21. Chạy container với tên cụ thể
`docker run -d --name my_nginx nginx`  
Chạy container nginx và đặt tên là `my_nginx`.
![img_21.png](img_21.png)

## 22. Giám sát tài nguyên container
`docker stats`  
Hiển thị thông tin về tài nguyên CPU, RAM mà container đang sử dụng.
![img_22.png](img_22.png)
## 23. Liệt kê mạng Docker
`docker network ls`  
Hiển thị danh sách các mạng Docker.
![img_23.png](img_23.png)

## 24. Tạo một mạng mới
`docker network create my_network`  
Tạo một mạng Docker tên `my_network`.
![img_24.png](img_24.png)

## 25. Chạy container và kết nối với mạng
`docker run -d --network my_network --name my_container nginx`  
Chạy container và kết nối vào mạng `my_network`.

## 26. Kết nối container với mạng
`docker network connect my_network my_nginx`  
Kết nối container `my_nginx` vào mạng `my_network`.
![img_25.png](img_25.png)
## 27. Chạy container với biến môi trường
`docker run -d -e MY_ENV=hello_world nginx`  
Chạy container và đặt biến môi trường `MY_ENV=hello_world`.
![img_26.png](img_26.png)
## 28. Theo dõi logs của container
`docker logs -f my_nginx`  
Theo dõi logs của container `my_nginx` theo thời gian thực.  
![img_27.png](img_27.png)