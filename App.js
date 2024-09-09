require('dotenv').config();
const { Client, GatewayIntentBits } = require('discord.js');

// Create a new client instance
const client = new Client({ 
    intents: [
        GatewayIntentBits.Guilds,
        GatewayIntentBits.GuildMessages,
        GatewayIntentBits.MessageContent
    ] 
});

client.once('ready', () => {
    console.log('Bot is online!');
});

// Listen to and echo messages
client.on('messageCreate', message => {
    if (message.author.bot) return;
    message.channel.send(`You said: ${message.content}`);
});

client.login(process.env.DISCORD_TOKEN);

