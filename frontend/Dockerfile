# Stage 1: Build da aplicação Angular
FROM node:18 as builder
WORKDIR /app
COPY . .
RUN npm install && ng build --prod

# Stage 2: Servidor NGINX
FROM nginx:alpine
COPY --from=builder /app/dist/angular-creditos /usr/share/nginx/html
EXPOSE 80