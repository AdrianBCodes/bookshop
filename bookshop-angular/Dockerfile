FROM node:16
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
# install and app dependencies
COPY package.json /app/package.json
RUN npm install
RUN npm install -g @angular/cli@16.0.1
# add app
COPY . /app
# start app
CMD ng serve --host 0.0.0.0
