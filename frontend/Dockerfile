FROM node:24.2.0-alpine as build

# Metadata
LABEL authors="anissingh"

# Set working directory to be something other than /
WORKDIR /usr/src/app

# Copy only files required to install dependencies
# Improves layer caching
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy remaining files
COPY . .

# Document port
EXPOSE 3000

# Run dev server
CMD ["npm", "run", "dev"]


