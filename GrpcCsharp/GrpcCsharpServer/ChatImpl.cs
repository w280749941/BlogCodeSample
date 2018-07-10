using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;
using Grpc.Core;
using Grpcsharp;

namespace GrpcCsharpServer
{
    class ChatImpl : Chat.ChatBase
    {
        private readonly string _serverName = "Super Server";
        private readonly int _serverNumber = 12;

        //Define the same method for the server side.
        public override Task<ServerHello> GetMessage(ClientHello request, ServerCallContext context)
        {
            string serverMessage = $@"Hello there {request.ClientName}";
            Console.WriteLine($@"Recevied message from client {request.ClientName}: {request.ClientMessage}");
            return Task.FromResult(new ServerHello { ServerMessage = serverMessage, ServerName = _serverName, ServerNumber = _serverNumber });
        }
    }
}
