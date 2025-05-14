FROM node:18 as builder
WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm install --global @angular/cli@18 \
    && ng build --configuration production

FROM nginx:alpine

COPY --from=builder /app/dist/consulta-credito/browser/ /usr/share/nginx/html/

EXPOSE 80
