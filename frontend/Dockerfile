FROM node:24.2.0-alpine as build

# Metadata
LABEL authors="anissingh"

# Set working directory to be something other than /
WORKDIR /usr/src/app

# Copy only files required to install dependencies
# Improves layer caching
COPY package*.json ./

# Install dependencies
RUN npm ci

# Set permissions for node user and set ownership of all files created
# in WORKDIR and node_modules.
RUN chown -R node:node /usr/src/app &&  \
    chmod g+s /usr/src/app &&  \
    chown -R node:node /usr/src/app/node_modules && \
    chmod g+s /usr/src/app/node_modules

# Copy remaining files
COPY --chown=node:node . .

# Document port
EXPOSE 3000

# Node has non-root user built-in
USER node

# Run dev server
CMD ["npm", "run", "dev"]


