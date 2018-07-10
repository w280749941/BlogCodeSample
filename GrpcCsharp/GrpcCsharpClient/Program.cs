using System;
using System.Threading.Tasks;
using Grpc.Core;
using Grpcsharp;

namespace GrpcShrpClient
{
    class Program
    {
        public static async Task Main(string[] args)
        {
            const int port = 50051;
            const string clientName = "Super user";

            Channel channel = new Channel("localhost", port, ChannelCredentials.Insecure);

            var client = new Chat.ChatClient(channel);

            while (true)
            {
                Console.WriteLine(@"Type a message to send, type exit to quit");
                string input = Console.ReadLine();
                if (input.ToLower().Equals("exit"))
                    break;
                var reply = await client.GetMessageAsync(new ClientHello { ClientName = clientName, ClientMessage = input });
                Console.WriteLine($@"Message from Server: {reply.ServerName} - {reply.ServerNumber}: {reply.ServerMessage}");
            }
            
            await channel.ShutdownAsync();
            Console.WriteLine("Press any key to exit...");
            
        }
    }
}